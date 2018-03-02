package com.music.DAO;

import java.util.List;

import com.music.model.Music;

public interface MusicDAO {
	
	
	public void addGenre(Music m);
	public void updateGenre(Music m);
	public void removeGenre(String gid);
	public List<Music> getGenre();
	public Music getGenrebyId(String gid);

}
