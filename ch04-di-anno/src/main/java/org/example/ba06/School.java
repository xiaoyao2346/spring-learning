package org.example.ba06;


import org.example.myannotation.Xiao;
import org.example.myannotation.XiaoHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myschool")
public class School {
    @Xiao("航空航天大学")
    private String name;
    @Xiao("北京市海淀区")
    private String address;

    public School(){
        XiaoHandler.xiaohandler(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
