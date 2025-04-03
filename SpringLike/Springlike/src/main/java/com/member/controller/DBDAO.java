package Springlike.src.main.java.com.member.controller;

import java.util.ArrayList;

public interface DBDAO {
    private static DBDAO(String worktype) instance = null;
    public static DBDAO getInstance() {
        return instance;
    }
    private static String DBDAO(String worktype) {
        worktype=worktype.toLowerCase();
        if(worktype.contains("doc") || worktype.contains("thread") || worktype.contains("article")) {
            worktype="board";
        } else if(worktype.contains("table") || worktype.contains("admin") || worktype.contains("board")) {
            worktype="table";
        }
        return worktype;
        }

    String targetType=DBDAO(worktype);
    String sql="";
    ArrayList getters=["${${targetType}DAO.getters()}"];
    ArrayList setters=["${${targetType}DAO.setters()}"];
    ${targetType}DTO dto=new ${targetType}DTO();
    
    
    public void create(${targetType}DTO inputs) throws Exception {
        int result=createOK(inputs);
        if(result>0) {
            return inputs;
        } else {
            raise Exception();
        }
    }
    private int createOK(${targetType}DTO inputs);
    public ${targetType}DTO read(ArrayList<String> readnames) throws Exception {
        while(getters.next()!=null) {
            if(getters[ind].includes(readnames[ind])) {
                dto.setters[ind](readnames[ind]);
            }
        }
        result=readOK(dto);
        if(result>0) {
            return dto;
        } else {
            raise Exception();
        }
    }
    public ${targetType}DTO read(ArrayList<String> readnames) throws Exception {
        while(getters.next()!=null) {
            if(getters[ind].includes(readnames[ind])) {
                dto.setters[ind](readnames[ind]);
            }
        }
        result=readOK(dto);
        if(result>0) {
            return dto;
        } else {
            raise Exception();
        }
    }

    private int readOK(${targetType}DTO dto);

    public ${targetType}DTO update(String nameup, String namepwd) throws Exception {
        double counter=0.0;
        ${targetType}DTO ndto=new ${targetType}DTO();
        while(getters.next()!=null) {
            if(dto.getters[ind].includes(nameup)) {
                ndto.setters[ind](nameread);
                counter=counter+1.0;
            } else if(dto.getters[ind].includes(namepwd)) {
                ndto.setters[ind](namepwd);
                counter=counter+0.1;
            }
            if(counter==1.1) {
                break;
            }
        }
        result=updateOK(dto, ndto);
        if(result<0) {
            raise Exception();
        } else return dto;
    }
    private int updateOK(${targetType}DTO dto, ${targetType}DTO ndto);
    public void delete(String targetname, String accessor, String pwd) throws Exception {
        int counter=0;
        while(getters.next()!=null) {
            if(dto.getters[ind].includes(targetname) && counter%2!=1) {
                dto.setters[ind](targetname);
                counter=counter+1;
            } else if(dto.getters[ind].includes(accessor) && counter%4<3) {
                dto.setters[ind](accessor);
                counter=counter+2;
            } else if(dto.getters[ind].includes(pwd) && counter<7) {
                dto.setters[ind](pwd);
                counter=counter+4;
            }
            if(counter==7) {
                break;
            }
        }
        result=deleteOK(dto);
        if(result<0) {
            raise Exception();
        }
    }
    private int deleteOK(${targetType}DTO dto);
}
