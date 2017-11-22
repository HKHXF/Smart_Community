package com.firstCapacity.business.book.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.book.entity.Book;
import com.firstCapacity.business.book.mapper.BookMapper;
import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.util.MD5Util;


@Transactional
@Service
public class bookServiceImpl implements bookService{

	@Autowired
	private BookMapper bookMapper;

	@Override
//	@Cacheable(value={"common"},key="'all_'+#book.getId()")
//	@Cacheable(value="common",key="'id_'+#book.getName()")
	public List<Book> selectAll(Book book) {
		
		List<Book> selectAll = bookMapper.selectAll(book);
		
		return selectAll;
	}
	



}
