package org.zdanek.corporis.weight;

public class WeightDTO {
	
	private Weight weight;
	private int pageNumber;
	private int pageSize;
	
	public Weight getWeight() {
		return weight;
	}
	public void setWeight(Weight weight) {
		this.weight = weight;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "WeightDTO [weight=" + weight + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}
	
	
	
}
