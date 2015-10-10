package com.ppusari.my.mybatis.db.dao;

import java.util.ArrayList;
 
import com.ppusari.my.mybatis.db.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String strId);
	public void deleteDao(String bId);	

}
