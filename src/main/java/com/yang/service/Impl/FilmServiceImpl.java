package com.yang.service.Impl;

import com.yang.dao.FilmDao;
import com.yang.model.Film;
import com.yang.service.FilmService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("filmService")
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmDao filmDao;
    public  Object[][] showSchedulInfor(){
        Object[][] objects=null;
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
        return objects;
    }

    public  String[] selectAllFname(){

        List<Film> filmList =filmDao.selectAllFilms();
        String[] str= new String[filmList.size()];
        for (int i = 0; i < filmList.size(); i++) {
            str[i] = filmList.get(i).getfName();
        }
        return str;
    }
    public  int findFid(String fname){
        int fid = 11101;
        List<Film> film = filmDao.findFilm(fname);
        Film film1 = film.get(0);
        if (film1!=null){
            return film1.getFid();
        }
        return fid;
    }
    public  Boolean addFilm(Film film){
        boolean flag = false;

        if (filmDao.addFilm(film)!=0){
            flag = true;
        }
        return flag;
    }
    public  Boolean delFilm(int fid){
        boolean flag = false;
        if (filmDao.deleteFilm(fid)!=0){
            flag = true;
        }
        return flag;
    }
    public  Object[][] findFilm(String fname){
        Object[][] objects=null;

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

        return objects;
    }



}
