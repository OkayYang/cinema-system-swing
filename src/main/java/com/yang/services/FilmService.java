package com.yang.services;

import com.yang.dao.FilmDao;
import com.yang.model.Film;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.List;

public class FilmService {
    public static Object[][] showSchedulInfor(){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        List<Film> filmList =filmDao.selectAllFilms();
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
        if (filmList.size()!=0){
            objects =new Object[filmList.size()][];
            for (int i = 0; i < filmList.size(); i++) {
                objects[i] = new Object[]{
                        filmList.get(i).getFid(),
                        filmList.get(i).getfName(),
                        filmList.get(i).getfType(),
                        filmList.get(i).getfRegion(),
                        filmList.get(i).getfDuration(),
                        sdf.format(filmList.get(i).getfDate()),
                        filmList.get(i).getfPrice()
                };
            }
        }
        sqlSession.close();

        return objects;
    }

}
