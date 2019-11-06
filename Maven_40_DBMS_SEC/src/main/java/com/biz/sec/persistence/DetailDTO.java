package com.biz.sec.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DetailDTO {
	private long d_seq;
	private long d_m_seq; // Master Table과 연계(relation)을 수행하는 key. foreign key
	private String d_subject;
	private String d_ok;
}
