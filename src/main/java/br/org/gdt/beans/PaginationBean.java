/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UICommand;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Alisson Allebrandt
 */

@ManagedBean(name="paginationBean")
public class PaginationBean implements Serializable{
    private transient HtmlDataTable  paginationDmdDataTable;
    
    //getter and setter methods for paginationDmdDataTable;
    private int totalRows;
    private int firstRow;
    private int rowsPerPage = 2;
    private int totalPages;
    private int pageRange = 10;
    private Integer[] pages ;
    private int currentPage;

    public HtmlDataTable getPaginationDmdDataTable() {
        return paginationDmdDataTable;
    }

    public void setPaginationDmdDataTable(HtmlDataTable paginationDmdDataTable) {
        this.paginationDmdDataTable = paginationDmdDataTable;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageRange() {
        return pageRange;
    }

    public void setPageRange(int pageRange) {
        this.pageRange = pageRange;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    //Providing all getter methods for the above attributes.
    public void loadData(){
        totalRows = paginationDmdDataTable.getRowCount();
        currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
        totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
        int pagesLength = Math.min(pageRange, totalPages);  
        pages = new Integer[pagesLength];
        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);
        // Create pages (page numbers for page links).
        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
    }
 
    public void page(ActionEvent event) {
        System.out.println((Integer) ((UICommand) event.getComponent()).getValue());
        page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
    }
 
    private void page(int firstRow) {
        this.firstRow = firstRow;
        loadData();
    }
    public Integer[] getPages() {
       loadData();
       return pages;
    }
}