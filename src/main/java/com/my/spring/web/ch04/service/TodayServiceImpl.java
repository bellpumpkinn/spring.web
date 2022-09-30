package com.my.spring.web.ch04.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.web.ch04.dao.TodayDao;

@Service
public class TodayServiceImpl implements TodayService{
	@Autowired private TodayDao todayDao;
	
	@Override
	public LocalDate getToday() {
		return todayDao.selectToday();
	}
}

//TodayDao에서의 Today는 data, domain
//TodayService에서의 Today는 업무명.
//TodayController에서의 Today도 업무명.