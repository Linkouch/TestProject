package models;

import java.util.List;

/**
 * Модель данных для ответа API.
 */
public class ResponseData {
    private int page;
    private int pageSize;
    private int totalCount;
    private List<Model> models;

    // Геттеры и сеттеры
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}