package net.mike.services;

import java.util.List;

public interface EmailsRegListService {
  
	public List<String> getAll();
	public String create(String email);
	public void update();
	public void delete(String email);
}
