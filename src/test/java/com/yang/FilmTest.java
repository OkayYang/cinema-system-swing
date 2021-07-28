package com.yang;

import com.yang.dao.AdminDao;
import com.yang.dao.FilmDao;
import com.yang.model.Film;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilmTest {
    @Test
    public void selectFilmTest(){
        /*SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        Film film  = filmDao.findFilm("金刚川");
        System.out.println(film);
        *//*List<Film> filmList = filmDao.selectAllFilms();
        for (Film film:filmList
             ) {
            System.out.println(film);
        }*//*
        sqlSession.close();*/
    }
    @Test
    public void addFilmTest() throws ParseException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        FilmDao filmDao = (FilmDao) applicationContext.getBean("filmDao") ;
        String sDate ="2020-04-20";
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
        Date dat =sdf.parse(sDate);

        Film film = new Film("速度与激情7","科幻","美国","170分钟",dat,60);
        int success =filmDao.addFilm(film);

        System.out.println("成功添加一部电影!");

    }
}
