package com.firstCapacity.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil
{
  private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

  public static <T> T json2JavaPojo(String jsonString, Class<T> pojoClass)
  {
    Object pojo = JSON.parseObject(jsonString, pojoClass);
    return (T) pojo;
  }

  public static Map<String, String> json2Map(String jsonString)
  {
    Map valueMap = (Map)JSON.parseObject(jsonString, Map.class);
    return valueMap;
  }

  public static <T> List<T> json2List(String jsonString, Class<T> pojoClass)
  {
    List list = JSON.parseArray(jsonString, pojoClass);
    return list;
  }

  public static String javaPojo2Json(Object object)
  {
    return javaPojo2Json(object, null);
  }

  public static String javaPojo2Json(Object object, List<String> includeProperties)
  {
    if (includeProperties == null) {
      includeProperties = new ArrayList();
    }
    JSONObject json = new JSONObject();
    Map map = new HashMap();
    Field[] fields = object.getClass().getDeclaredFields();
    label172: for (Field f : fields) {
      try {
        String key = f.getName();
        f.setAccessible(true);
        if ((Modifier.isFinal(f.getModifiers())) || (Modifier.isStatic(f.getModifiers()))) {
          map.put(key, f.get(object));
          break label172;
        }
        if ((isBaseType(f.getType())) || (f.getType() == String.class))
          map.put(key, invokeGetterMethod(object, key));
      }
      catch (SecurityException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    json = new JSONObject(map);
//    for (??? = includeProperties.iterator(); ((Iterator)???).hasNext(); ) { String prop = (String)((Iterator)???).next();
//      fillValue(json, prop, object);
//    }
    return ((String)json.toString());
  }

  public static String collection2Json(Collection<? extends Object> collections) {
    return collection2Json(collections, null);
  }

  public static String collection2Json(Collection<? extends Object> collections, List<String> includeProperties)
  {
    if (includeProperties == null) {
      includeProperties = new ArrayList();
    }
    JSONArray result = new JSONArray();
    if (collections.size() == 0) {
      return result.toString();
    }
    Object obj = collections.iterator().next();
    if (obj instanceof Map) {
      return JSONArray.toJSONString(collections);
    }

    for (obj = collections.iterator(); ((Iterator<? extends Object>) obj).hasNext(); ) { Object object = ((Iterator<? extends Object>) obj).next();
      if (object == null) {
        continue;
      }
      JSONObject json = new JSONObject();
      Map map = new HashMap();

      Field[] fields = object.getClass().getDeclaredFields();
      for (Field f : fields) {
        try {
          String key = f.getName();
          f.setAccessible(true);
          if ((Modifier.isFinal(f.getModifiers())) || (Modifier.isStatic(f.getModifiers()))) {
            map.put(key, f.get(object));
            break ;
          }
          if ((isBaseType(f.getType())) || (f.getType() == String.class))
            map.put(key, invokeGetterMethod(object, key));
        }
        catch (SecurityException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
      json = new JSONObject(map);
//      for (??? = includeProperties.iterator(); ((Iterator)???).hasNext(); ) { String prop = (String)((Iterator)???).next();
//        fillValue(json, prop, object);
//      }
      result.add(json);
    }
    label257: return ((String)result.toString());
  }

  private static void fillValue(JSONObject json, String prop, Object object) {
    if (object == null) {
      return;
    }
    if (prop.contains(".")) {
      JSONObject jsonObj;
      Object value;
      String key = prop.substring(0, prop.indexOf("."));
      if (!(json.containsKey(key))) {
        jsonObj = new JSONObject();
        value = invokeGetterMethod(object, key);
        fillValue(jsonObj, prop.replaceFirst(key + ".", ""), value);
        json.put(key, jsonObj);
      } else {
        jsonObj = json.getJSONObject(key);
        value = invokeGetterMethod(object, key);
        fillValue(jsonObj, prop.replaceFirst(key + ".", ""), value);
        json.remove(key);
        json.put(key, jsonObj);
      }
    } else {
      Object value = invokeGetterMethod(object, prop);
      json.put(prop, value);
    }
  }

  private static Object invokeGetterMethod(Object target, String propertyName) {
    String getterMethodName = "get" + StringUtils.capitalize(propertyName);
    Method m = getGetterMethod(getterMethodName, target);
    if (m == null) {
      m = getGetterMethod("is" + StringUtils.capitalize(propertyName), target);
    }
    if (m == null)
      return null;
    try
    {
      return m.invoke(target, new Object[0]);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static Method getGetterMethod(String getterMethodName, Object target) {
    Method[] methods = target.getClass().getDeclaredMethods();
    for (Method m : methods) {
      if ((((m.getParameterTypes() == null) || (m.getParameterTypes().length == 0))) && 
        (m.getName().endsWith(getterMethodName))) {
        return m;
      }
    }

    return null;
  }

  private static boolean isBaseType(Class<?> type) {
    if (type.isPrimitive()) {
      return true;
    }

    return ((type != Integer.class) && (type != Boolean.class) && (type != Character.class) && (type != Byte.class) && (type != Short.class) && (type != Long.class) && (type != Float.class) && (type != Double.class));
  }

  public static String map2Json(Map<String, ?> map)
  {
    Map map2 = map;
    return new JSONObject(map2).toJSONString();
  }

  public static Map<String, Object> jsonToMap(String json)
  {
    if (StringUtils.isBlank(json)) {
      return null;
    }
    JSONObject jsonObject = JSONObject.parseObject(json);
    return jsonToMap(jsonObject);
  }

  public static Map<String, Object> jsonToMap(JSONObject jsonObject)
  {
    if ((jsonObject == null) || (!(jsonObject instanceof JSONObject))) {
      return null;
    }
    Map data = (Map)JSONObject.toJavaObject(jsonObject, Map.class);
    return data;
  }

  public static <X> X jsonToBean(String json, Class<?> clazz) {
    if (StringUtils.isBlank(json)) {
      return null;
    }
    JSONObject jsonObject = JSONObject.parseObject(json);
    return jsonToBean(jsonObject, clazz);
  }

  public static <X> X jsonToBean(Object object, Class<?> clazz)
  {
    if ((object == null) || (!(object instanceof JSONObject))) {
      return null;
    }
    return (X) JSONObject.toJavaObject((JSONObject)object, clazz);
  }

  public static <X> List<X> jsonToBeans(String json, Class<?> clazz) {
    if (StringUtils.isBlank(json)) {
      return null;
    }
    JSONArray data = JSONArray.parseArray(json);
    if ((data == null) || (clazz == null)) {
      return null;
    }
    List dataList = new ArrayList();
    JSONArray datas = data;
    for (int i = 0; i < datas.size(); ++i) {
      Object object = datas.get(i);
      Object x = jsonToBean(object, clazz);
      dataList.add(x);
    }
    return dataList;
  }

  public static Map<String, String> parseSimpleJsonStrToMap(String str)
  {
    Map result = new LinkedHashMap();

    throw new RuntimeException("此方法未实现实际功能");
  }

  public static String readJsonFile(String filePath) {
    String data = "";
    try {
      String encoding = "UTF-8";
      File file = new File(filePath);
      if ((file.isFile()) && (file.exists())) {
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
          if (lineTxt.startsWith("#")) {
            continue;
          }
          data = data + lineTxt;
        }

        read.close();
      } else {
        log.error("找不到指定的文件");
      }
    } catch (Exception e) {
      log.error("读取文件内容出错");
      e.printStackTrace();
    }
    return data;
  }
}