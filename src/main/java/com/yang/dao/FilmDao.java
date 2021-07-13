package com.yang.dao;

import com.yang.model.Film;

import java.util.List;

public interface FilmDao {
    /**
     * 查看所有院线电影
     * @return
     */
    List<Film> selectAllFilms();
    int deleteFilm(int fid);
    /**
     * 更改电影票价格
     * @param film
     * @return
     */
    int updateFilm(Film film);

    /**
     * 添加一部电影
     * @param film
     * @return
     */

    int addFilm(Film film);

    List<Film> findFilm(String fname);



}
