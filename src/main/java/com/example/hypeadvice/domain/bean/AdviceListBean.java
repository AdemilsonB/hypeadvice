package com.example.hypeadvice.domain.bean;

import com.example.hypeadvice.domain.entity.Advice;
import com.example.hypeadvice.domain.service.AdviceService;
import com.example.hypeadvice.domain.vo.AdviceListVO;
import com.example.hypeadvice.domain.vo.AdviceVO;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AdviceListBean extends Bean {

    @Autowired AdviceService adviceService;

    private Advice advice = new Advice();
    private AdviceListVO adviceListVO;

    private AdviceVO adviceVO;

    public void initBean() {
        advice = new Advice();
    }

    public void buscar() {
        try {
            this.adviceListVO = adviceService.buscar(advice);
        } catch (Exception e) {
            addMessageError(e);
        }
    }

    public void buscarPorID(){
        try {
            this.adviceVO = adviceService.buscarPorID(advice);
        } catch (Exception e) {
            addMessageError(e);
        }
    }

    public AdviceListVO getAdviceListVO() {
        return adviceListVO;
    }
    public List<AdviceVO> getAdviceVO() {
        List<AdviceVO> list = new ArrayList<>();
        list.add(adviceVO);
        return  list;
    }

    public void setAdviceListVO(AdviceListVO adviceListVO) {
        this.adviceListVO = adviceListVO;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
