package model;

public class Request {
   
	 private String Worker;
	 private String Time;
	 private String Address;
	 private int Request_Id;
	public String getWorker() {
		return Worker;
	}
	public void setWorker(String worker) {
		Worker = worker;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getRequest_Id() {
		return Request_Id;
	}
	public void setRequest_Id(int request_Id) {
		Request_Id = request_Id;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(String worker, String time, String address, int request_Id) {
		super();
		Worker = worker;
		Time = time;
		Address = address;
		Request_Id = request_Id;
	}
	public Request(String worker, String time, String address) {
		super();
		Worker = worker;
		Time = time;
		Address = address;
	}
	 
	 
}
