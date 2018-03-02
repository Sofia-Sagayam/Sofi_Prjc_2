package com.music.service;

import java.util.List;

import com.music.model.Music;

public interface MusicServDao {
public void addGenre(Music m);
public void updateGenre(Music m);
public void removeGenre(String gid);
public List<Music> listMusic();
public Music getGenrebyId(String gid);

}
