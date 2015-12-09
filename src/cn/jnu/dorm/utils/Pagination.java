package cn.jnu.dorm.utils;

import java.util.List;

public class Pagination {
	
	// ָ���Ļ���ҳ�����
	private int currentPage; // ��ǰҳ
	private int pageSize; // ÿҳ��ʾ������

	// ��ѯ���ݿ�
	private int recordCount; // �ܼ�¼��
	private List recordList; // ��ҳ�������б�

	// ����
	private int pageCount; // ��ҳ��
	private int beginPageIndex; // ҳ���б�Ŀ�ʼ������������
	private int endPageIndex; // ҳ���б�Ľ���������������
	
	public Pagination(int currentPage, int pageSize, int recordCount,
			List recordList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		//������ҳ��
		if((recordCount%pageSize) == 0) {
			this.pageCount = recordCount/pageSize;
		} else {
			this.pageCount = recordCount/pageSize + 1;
		}
		
		//���㿪ʼҳ��ͽ���ҳ��
		if(pageCount <= 10) {
			this.beginPageIndex = 1;
			this.endPageIndex = pageCount;
		} else {
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			if(beginPageIndex < 1) {
				beginPageIndex = 1;
			}
			if(endPageIndex > pageCount) {
				endPageIndex = pageCount;
			}
		}
		
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
}
