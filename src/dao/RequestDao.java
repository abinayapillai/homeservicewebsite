package dao;

import java.util.List;

import model.Request;

public interface RequestDao {
	public void addRequest(Request request);
	public Request getRequestById(int requestId);
	public List<Request> getAllRequest();
	public void updateRequest(Request request);
	public void DeleteRequest(int requestId);
}
