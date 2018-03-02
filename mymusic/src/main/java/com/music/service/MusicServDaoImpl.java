package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.DAO.MusicDAO;
import com.music.DAO.MusicDaoImpl;
import com.music.model.Music;

@Service

public class MusicServDaoImpl implements MusicServDao {

@Autowired
	 MusicDAO md;
       
	@Transactional
	public void addGenre(Music m) {
		md.addGenre(m);
		} 
@Transactional
	public void updateGenre(Music m) {
		md.updateGenre(m);
		}
	@Transactional
	public List<Music> listMusic() {
				return md.getGenre();
	}
		@Transactional
	public void removeGenre(String gid) {
		md.removeGenre(gid);
			}
		
@Transactional
	public Music getGenrebyId(String gid) {
				return md.getGenrebyId(gid);
	}


}
