package org.zdanek.corporis.weight;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="weight", schema="public")
public class Weight {
	
	@Id
    @GeneratedValue(generator="weight_id_seq")
	@Column
	private Long id;//id bigint NOT NULL DEFAULT nextval('weight_id_seq'::regclass),
	
	@Column
	private Date date;//date timestamp with time zone,
	
	@Column
	private Long userId;//user_id bigint,
	
	@Column
	private double weight;//weight numeric,
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Weight [id=" + id + ", date=" + date + ", userId=" + userId + ", weight=" + weight + "]";
	}
	
}
