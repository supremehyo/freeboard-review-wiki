package com.example.demo.pageMaker;

public class PageMaker {
    private int totalcount;//��ü �Խù� ����
    private int countlist;
    private int pagenum;//ù�������� ǥ���ϱ� ����, ������ ��ȣ�� ��Ÿ����
    private int contentnum=10;//���������� � ������
    private int startPage=1;//beginpage ����Ʈ 1
    private int endPage=5;//endpage ����Ʈ 5
    private boolean prev=false;//���� ������ ȭ��ǥ
    private boolean next;//���� ������ ȭ��ǥ
    private int currentblock=1;
    private int lastblock;
    
    public boolean isPrev() {
        return prev;
    }
 
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
 
    public boolean isNext() {
        return next;
    }
 
    public void setNext(boolean next) {
        this.next = next;
    }
 
    public int getStartPage() {
        return startPage;
    }
 
    public void setStartPage(int currentblock) {
        this.startPage = (currentblock*5)-4;
        //�� �������� 5���� �������Ƿ�
        //���� ������ ����� ��ȣ * ��ϴ� �������� ����(5) - 4�� �ϸ� ���� ������ ��ȣ�� ���� �� �ִ�
    }
 
    public int getEndPage() {
        return endPage;
    }
 
    public void setEndPage(int getlastblock,int getcurrentblock) {
        if (getlastblock==getcurrentblock) {
            this.endPage = calcpage(getTotalcount(),getContentnum());
        }
        else {
            this.endPage = getStartPage()+4;
        }
        //�⺻ ���������� +4
        //���� , ������ ������ ����̸� ������ ������ ��ȣ
    }
    
 
    public int getCurrentblock() {
        return currentblock;
    }
 
    public void setCurrentblock(int pagenum) {//���� ������ ����� ��ȣ�� ������� �������ִ� �Լ�
//        ��������ȣ / ������ �׷� ���� ������ ����(5)
//        ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ���� ��� ��ȣ��� �θ���. cblock
 
        this.currentblock = pagenum/5;
        if (pagenum%5>0) {
            this.currentblock++;
        }
    }
 
    public int getLastblock() {
        return lastblock;
    }
 
    public void setLastblock(int totalcount) {//������ ������ ����� ��ȣ�� ���� �������ִ� �Լ�
        //��ü �� ������ ����ؼ� �����Ѵ�
        this.lastblock = totalcount / (5*this.contentnum);
        if (totalcount%(5*this.contentnum)>0) {
            this.lastblock++;
        }
//        ��ü �� ����(128) / ������ �׷� ���� ������ ����(5) * ���������� �� ����(10)
//        ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ������ ��� ��ȣ��� �θ���. last block
    }
 
    public void prevnext(int pagenum) {
        
        if (pagenum>0 && pagenum<6) {
            setPrev(false);
            setNext(true);
        }
        else if(getLastblock()==getCurrentblock()) {//5���� �������� �׷��ȣ�� �����Ѵ�.
            //�׷� ��ȣ�� 3�̶�� ���� �ش� ������ �׷��� �������̶�� ���̱⿡ ���� ȭ��ǥ�� Ȱ��ȭ�Ѵ� 
            //�� �ΰ��� ���ٸ� ������ ����̹Ƿ� ������ �ְ� ���İ� ����.

            setPrev(true);
            setNext(false);        
        }
        else {
            setPrev(true);
            setNext(true);
        }
    }
    public int calcpage(int totalcount,int contentnum) {//��ü ������������ ������ �Լ��� ����Ѵ�
        int totalpage = totalcount/contentnum;//��ü �Խù� ���� �� �������� � ���̴����� ������
        if (totalcount % contentnum>0) {//�׸��� �������� �ִٸ� 1�� ���ؼ� �� ������ ���� ��Ų��
            totalpage++;
        }
        if (totalpage<this.pagenum) {
            this.pagenum=totalpage;
        }
        return totalpage;//������ ������ �����Ѵ�
    }
 
    public int getTotalcount() {
        return totalcount;
    }
 
    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
    public int getCountlist() {
        return countlist;
    }
 
    public void setCountlist(int countlist) {
        this.countlist = countlist;
    }
 
    public int getPagenum() {
        return pagenum;
    }
 
    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }
 
    public int getContentnum() {
        return contentnum;
    }
 
    public void setContentnum(int contentnum) {
        this.contentnum = contentnum;
    }
    
 
}