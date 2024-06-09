package com.example.demo.pageDomain;

import com.example.demo.pageDomein.entity.Frame;

import lombok.Getter;
import lombok.Setter;

/*
 * 画面表示のベースとなるページオブジェクト。
 * 1つのベースフレームとそれに紐づくFrameやContentsの集合体として定義される。
 */
public class PageModel {
	
	@Getter
	@Setter
	private Frame baseFrame;
	
	public PageModel() {
		
//		this.baseFrame.getTitleContentId()
	}
}