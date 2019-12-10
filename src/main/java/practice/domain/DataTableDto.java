package practice.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;

@Data
public class DataTableDto {
	
	private int draw; 
    private int recordsTotal; 
    private int recordsFiltered; 

    private List<RoomDto> data; 

    public List<RoomDto> getData(){ 
    	if(CollectionUtils.isEmpty(data)){ 
    		data = new ArrayList<>(); 
        } 
        return data; 
    }
}
