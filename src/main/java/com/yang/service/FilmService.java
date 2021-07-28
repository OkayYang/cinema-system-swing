package com.yang.service;

import com.yang.model.Film;

public interface FilmService {
    Object[][] showSchedulInfor();
    String[] selectAllFname();
    int findFid(String fname);
    Boolean addFilm(Film film);
    Boolean delFilm(int fid);
    Object[][] findFilm(String fname);
}
