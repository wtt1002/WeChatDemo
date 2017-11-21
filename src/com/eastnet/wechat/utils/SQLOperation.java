package com.eastnet.wechat.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperation {

	public String addImage(String fromUserName,String picUrl,String mediaId) {
		Connection conn=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
		//conn = new DBCPConnection().getConnection();
		conn=new MySQLBasic().getConnection();
	    String sql = "insert into Images (ImageId,UserId,status,imagePath,timestamp) values(?,?,?,?,?)";
	    int update=0;
	    try {
	    	ps = conn.prepareStatement(sql);
	    	ps.setString(1, mediaId);
	    	ps.setString(2, fromUserName);
	    	ps.setInt(3, 1);
	    	ps.setString(4, picUrl);
	    	long time=System.currentTimeMillis();
	    	ps.setString(5, String.valueOf(time));
	        update=ps.executeUpdate();
	        if(update>0){
	        	//return "用户名绑定成功";
	        	System.out.println("insert successful");
	        	return "insert successful";
	        	
	        }else{
	        	//return "用户名绑定失败";
	        	System.out.println("insert default");
	        	return "insert default";
	        }
	    } catch (SQLException e) {
	    	//return "用户名绑定失败，未知错误";
	    	System.out.println("unknown default");
	    	return "unknown default";
	    }finally{
	    	closeConnection(conn,ps,rs);
	    }
	}
	
	
	//获取图片链接
	public List<String> getImagePath() {
		Connection conn=null;
		List<String> list=new ArrayList<String>();
	    PreparedStatement ps=null;
	    ResultSet rs=null;
		
		conn=new MySQLBasic().getConnection();
		String selectSql="select * from Images ";
		if(conn==null){
			return null;
		}else{
			try {
				ps=conn.prepareStatement(selectSql);
				rs=ps.executeQuery();
				while(rs.next()){
					list.add(rs.getString("imagePath"));
				}
			} catch (SQLException e) {
				return null;
			}finally{
				closeConnection(conn,ps,rs);
			}
		}
		
		return list;
	}
	
	public void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs=null;
            }
        }
        
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                ps=null;
            }
        }
        
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn=null;
            }
        }
	}
	
}
