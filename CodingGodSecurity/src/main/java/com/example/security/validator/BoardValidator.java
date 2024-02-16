package com.example.security.validator;

import com.example.security.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    public boolean supports(Class clazz) {
        return Board.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        //ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Board board = (Board) obj;
        if (StringUtils.isEmpty(board.getContent())){
            e.rejectValue("content", "key", "내용을 입력하세요.");
        }
    }
}