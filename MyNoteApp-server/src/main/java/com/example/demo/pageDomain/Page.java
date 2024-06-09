package com.example.demo.pageDomain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.example.demo.pageDomein.entity.Frame;

import lombok.Getter;
import lombok.Setter;

public class Page {
	
//	@Autowired
//	private DatabaseConnector databaseConnector;
	
	@Getter
	@Setter
	private PageModel page;
	
	@Getter
	@Setter
	private Date createdDate;
	
	public Page setup(String baseFrameId) {
		this.setPage(this.pageFactory(baseFrameId));
		this.setCreatedDate(this.getPage().getBaseFrame().getCreatedDate());
		return this;
	}
	
	public PageModel pageFactory(String baseFrameId){
		PageModel page = new PageModel();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			// TODO 区分値に変える！
			String getBaseFrameQuery = "SELECT * FROM t_frame where "+ 
					"frame_id = '" + baseFrameId + "' and " +
					"base_flame_flg = '1' ";
			try (PreparedStatement statement = connection.prepareStatement(getBaseFrameQuery)) {
				try (ResultSet r = statement.executeQuery()) {
					while (r.next()) {
						Frame frame = new Frame();
						frame.setResultSet(r);
						page.setBaseFrame(frame);// FrameをPageModelに詰める
						this.setPage(page);// PageModelをpageに詰める
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.page;
	}
}