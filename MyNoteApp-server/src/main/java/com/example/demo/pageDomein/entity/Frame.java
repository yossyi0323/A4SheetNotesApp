package com.example.demo.pageDomein.entity;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.pageDomain.DatabaseConnector;

import lombok.Getter;
import lombok.Setter;

public class Frame {

	@Getter
	@Setter
	private String frameId;
	@Getter
	@Setter
	private String baseFrameFlg;
	@Getter
	@Setter
	private String frameType;
	@Getter
	@Setter
	private String titleContentId;
	@Getter
	@Setter
	private List<String> childrenOrder;
	@Getter
	@Setter
	private Date createdDate;
	@Getter
	@Setter
	private Date updatedDate;

	@Getter
	@Setter
	private Content titleContent;
	
	@Getter
	@Setter
	private List<Frame> childFrames;

	@Getter
	@Setter
	private List<Content> childContents;

//	@Autowired
//	private DatabaseConnector databaseConnector;
	
	public Frame() {
		
	}
	public Frame setup() {
		this.setTitleContent(this.getTitleContent());
		this.setChildFrames(this.getChildFrames());
		this.setChildContents(this.getChildContents());
		return this;
	}

	public Frame(String frameId, String baseFrameFlg, String frameType, String titleContentId, List<String> childrenOrder,
			Date createdDate, Date updatedDate) {
		this.setFrameId(frameId);
		this.setBaseFrameFlg(baseFrameFlg);
		this.setFrameType(frameType);
		this.setTitleContentId(titleContentId);
		this.setChildrenOrder(childrenOrder);
		this.setCreatedDate(createdDate);
		this.setUpdatedDate(updatedDate);
		setup();
	}

	public Frame setResultSet(ResultSet r) throws SQLException {
		this.setFrameId(r.getString("frame_id"));
		this.setBaseFrameFlg(r.getString("base_flame_flg"));
		this.setFrameType(r.getString("frame_type"));
		this.setTitleContentId(r.getString("title_content_id"));
		 Array sqlArray = r.getArray("children_order") != null ? r.getArray("children_order") : (Array) new Object();
		this.setChildrenOrder(Arrays.asList((String[])sqlArray.getArray()));
		this.setCreatedDate(r.getDate("created_date"));
		this.setUpdatedDate(r.getDate("updated_date"));
		setup();
		return this;
	}

	public List<String> getChildContentIds() {
		List<String> childContentIds = new ArrayList<String>();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			String query = "SELECT content_id FROM r_frame_content where frame_id = '" + this.getFrameId() + "'";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				try (ResultSet r = statement.executeQuery()) {
					while (r.next()) {
						childContentIds.add(r.getString("content_id"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return childContentIds;
	}

	public List<Content> getChildContents() {
		List<Content> childContents = new ArrayList<Content>();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			List<String> childContentIds = getChildContentIds();
			childContentIds.stream().forEach(id -> {
				String query = "SELECT * FROM t_content where content_id = '" + id + "'";
				try (PreparedStatement statement = connection.prepareStatement(query)) {
					try (ResultSet r = statement.executeQuery()) {
						while (r.next()) {
							Content content = new Content();
							childContents.add(content.setResultSet(r));
						}
					}
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return childContents;
	}

	public Content getTitleContent() {
		Content titleContent = new Content();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			String query = "SELECT * FROM t_content where content_id = '" + this.getTitleContentId() + "'";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				try (ResultSet r = statement.executeQuery()) {
					while (r.next()) {
						titleContent.setResultSet(r);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleContent;
	}

	public List<String> getChildFrameIds() {
		List<String> childFrameIds = new ArrayList<String>();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			String query = "SELECT child_id FROM r_frames where parent_id = '" + this.getFrameId() + "'";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				try (ResultSet r = statement.executeQuery()) {
					while (r.next()) {
						childFrameIds.add(r.getString("child_id"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return childFrameIds;
	}

	public List<Frame> getChildFrames() {
		List<Frame> childFrames = new ArrayList<Frame>();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		try (Connection connection = databaseConnector.getConnection()) {
			List<String> childFrameIds = getChildFrameIds();
			childFrameIds.stream().forEach(id -> {
				String query = "SELECT * FROM t_frame where frame_id = '" + id + "'";
				try (PreparedStatement statement = connection.prepareStatement(query)) {
					try (ResultSet r = statement.executeQuery()) {
						while (r.next()) {
							Frame frame = new Frame();
							childFrames.add(frame.setResultSet(r));
						}
					}
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return childFrames;
	}

}
