package com.yang.services;

import com.yang.dao.FilmDao;
import com.yang.dao.SchedulDao;
import com.yang.model.Film;
import com.yang.model.Schedul_infor;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static String[] selectAllFname(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao =sqlSession.getMapper(FilmDao.class);
        List<Film> filmList =filmDao.selectAllFilms();
        String[] str= new String[filmList.size()];
        for (int i = 0; i < filmList.size(); i++) {
            str[i] = filmList.get(i).getfName();
        }
        sqlSession.close();
        return str;
    }
    public static int findFid(String fname){
        int fid = 11101;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao =sqlSession.getMapper(FilmDao.class);
        List<Film> film = filmDao.findFilm(fname);
        Film film1 = film.get(0);
        if (film1!=null){
            return film1.getFid();
        }
        return fid;
    }
    public static Boolean addFilm(Film film){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        if (filmDao.addFilm(film)!=0){
            flag = true;
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
    public static Boolean delFilm(int fid){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        if (filmDao.deleteFilm(fid)!=0){
            flag = true;
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
    public static Object[][] findFilm(String fname){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FilmDao filmDao = sqlSession.getMapper(FilmDao.class);
        List<Film> filmList =filmDao.findFilm(fname);
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
