package com.example.demo8.validator;

import com.example.demo8.controller.LopController;
import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator(value = "classValidator")
public class ClassValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            Lop lop = (Lop)  uiComponent.getValueExpression("lop").getValue(facesContext.getELContext());
            boolean notContain = true;
            int lopTruongId = Integer.parseInt(o.toString());
            for (SinhVien sinhVien : lop.getSinhVienList()) {
                notContain = notContain && (sinhVien.getId() != lopTruongId);
            }
            if (notContain) {
                throw new ValidatorException(new FacesMessage("Id k hop le"));
            }
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage("Id k hop le"));
        }
    }
}
