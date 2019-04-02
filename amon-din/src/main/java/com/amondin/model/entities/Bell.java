package com.amondin.model.entities;

import java.util.Date;

public class Bell {

    private Long id;
    private Date date;

    //Пустой конструктор нужен для работы с JSON
    public Bell() {
    }

    public Bell(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bell bell = (Bell) o;

        if (!id.equals(bell.id)) return false;
        return date.equals(bell.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bell{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

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
}
