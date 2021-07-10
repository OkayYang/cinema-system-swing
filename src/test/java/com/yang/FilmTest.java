package com.yang;

import com.yang.dao.FilmDao;
import com.yang.model.Film;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilmTest {
    @Test
    public void selectFilmTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        List<Film> filmList = filmDao.selectAllFilms();
        for (Film film:filmList
             ) {
            System.out.println(film);
        }
        sqlSession.close();
    }
    @Test
    public void addFilmTest() throws ParseException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        String sDate ="2020-04-20";
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
        Date dat =sdf.parse(sDate);

        Film film = new Film("速度与激情7","科幻","美国","170分钟",dat,60);
        int success =filmDao.addFilm(film);
        sqlSession.commit();
        System.out.println("成功添加一部电影!");
        sqlSession.close();
    }
}
