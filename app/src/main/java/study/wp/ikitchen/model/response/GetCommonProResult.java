package study.wp.ikitchen.model.response;

import java.util.List;

import study.wp.ikitchen.model.PCookpeople;
import study.wp.ikitchen.model.PCooktime;
import study.wp.ikitchen.model.PCookway;
import study.wp.ikitchen.model.PHardlevel;
import study.wp.ikitchen.model.PTaste;
import study.wp.ikitchen.model.Tagdata;
import study.wp.ikitchen.model.Type;

/**
 * Created by wp on 2015-03-04.
 */
public class GetCommonProResult {
    private String status;
    private String errorMsg;
    private List<Type> typeList;
    private List<PCookway> pcookwayList;
    private List<PTaste> ptasteList;
    private List<PCooktime> pcooktimeList;
    private List<PCookpeople> pcookpeopleList;
    private List<PHardlevel> phardlevelList;
    private List<Tagdata> tagdataList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<PCookway> getPcookwayList() {
        return pcookwayList;
    }

    public void setPcookwayList(List<PCookway> pcookwayList) {
        this.pcookwayList = pcookwayList;
    }

    public List<PTaste> getPtasteList() {
        return ptasteList;
    }

    public void setPtasteList(List<PTaste> ptasteList) {
        this.ptasteList = ptasteList;
    }

    public List<PCooktime> getPcooktimeList() {
        return pcooktimeList;
    }

    public void setPcooktimeList(List<PCooktime> pcooktimeList) {
        this.pcooktimeList = pcooktimeList;
    }

    public List<PCookpeople> getPcookpeopleList() {
        return pcookpeopleList;
    }

    public void setPcookpeopleList(List<PCookpeople> pcookpeopleList) {
        this.pcookpeopleList = pcookpeopleList;
    }

    public List<PHardlevel> getPhardlevelList() {
        return phardlevelList;
    }

    public void setPhardlevelList(List<PHardlevel> phardlevelList) {
        this.phardlevelList = phardlevelList;
    }

    public List<Tagdata> getTagdataList() {
        return tagdataList;
    }

    public void setTagdataList(List<Tagdata> tagdataList) {
        this.tagdataList = tagdataList;
    }
}
