package com.example.demo.controller;

import com.example.demo.config.AllowedVersion;
import com.example.demo.config.AppVerionConfig;
import com.example.demo.config.Flag;
import com.example.demo.config.PershingConfig;
import com.example.demo.domain.Electronics;
import com.example.demo.domain.InvestmentInfoVO;
import com.example.demo.domain.MobileVersionVO;
import com.example.demo.domain.Person;
import com.example.demo.domain.ProfileWithSettlementOption;
import com.example.demo.domain.School;
import com.example.demo.exception.AppVersionException;
import com.example.demo.validator.InvestmentInfoVOValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private List<Person> personList;

    @Autowired
    private PershingConfig pershingConfig;

    @Autowired
    private Flag flag;

    @Autowired
    private AllowedVersion allowedVersion;

    @Autowired
    private AppVerionConfig appVerionConfig;


    @GetMapping("/allowVersion")
    public boolean allowVersion(@RequestParam("appVersion") String appversion) {
        if (StringUtils.isEmpty(appversion) || !appversion.matches("^\\d+(\\.\\d+)*$")) {
            throw new AppVersionException(appversion);
        }
        ComparableVersion appVersionReceived = new ComparableVersion(appversion);
        for (String allowed : allowedVersion.getAllowedVersions()) {
            if (checkVersion(appVersionReceived, allowed)) return true;
        }
        return false;
    }


    @GetMapping("/testing")
    public boolean testing(@RequestHeader("appId") String appId, @RequestHeader("appVersion") String appVersion) {
        if (StringUtils.isEmpty(appVersion) || !appVersion.matches("^\\d+(\\.\\d+)*$")) {
            throw new AppVersionException(appVersion);
        }
        return checkVersion(appVersion, appId);
    }

    private boolean checkVersion(String appVersion, String appId) {
        for (MobileVersionVO mobileVersionVO : appVerionConfig.getAllowed()) {
            if (mobileVersionVO.getAppId().equalsIgnoreCase(appId)) {
                return allowedVersionCheck(appVersion, mobileVersionVO.getAppVersion());
            }
        }
        return false;
    }


    private boolean allowedVersionCheck(String appVersion, List<String> allowedVersions) {
        ComparableVersion appVersionReceived = new ComparableVersion(appVersion);
        for (String allowed : allowedVersions) {
            if (checkVersion(appVersionReceived, allowed)) return true;
        }
        return false;
    }

    private boolean checkVersion(ComparableVersion appVersionReceived, String allowed) {
        if (allowed.contains(">")) {
            allowed = StringUtils.substring(allowed, 0, allowed.length() - 1);
            if (appVersionReceived.compareTo(new ComparableVersion(allowed)) >= 0) {
                return true;
            }
        } else if (allowed.contains("-")) {
            String[] allow = allowed.split("\\-");
            if (appVersionReceived.compareTo(new ComparableVersion(allow[0])) >= 0 && appVersionReceived.compareTo(new ComparableVersion(allow[1])) <= 0) {
                return true;
            }
        } else if (appVersionReceived.compareTo(new ComparableVersion(allowed)) == 0) {
            return true;
        }
        return false;
    }


    @GetMapping("/getFlag")
    public ProfileWithSettlementOption getFlag(@RequestParam("flowType") String flowType) {
        ProfileWithSettlementOption profileWithSettlementOption = new ProfileWithSettlementOption();
        profileWithSettlementOption.setCz4Flag(checkCz4Flag(flowType));
        profileWithSettlementOption.setSuitabilityFlag(checkSuitabilityFlag(flowType));
        profileWithSettlementOption.setRiskFlag(checkRiskFlag(flowType));
        profileWithSettlementOption.setDominantFlag(checkDominantFlag(flowType));
        return profileWithSettlementOption;
    }

    private boolean checkCz4Flag(String flowType) {
        return (flag != null && flag.getCz4().contains(flowType));
    }

    private boolean checkSuitabilityFlag(String flowType) {
        return (flag != null && flag.getSuitability().contains(flowType));
    }

    private boolean checkRiskFlag(String flowType) {
        return (flag != null && flag.getRisk().contains(flowType));
    }

    private boolean checkDominantFlag(String flowType) {
        return (flag != null && flag.getDomiant().contains(flowType));
    }


    @GetMapping("/get")
    public List<Person> getPerson() {
        return personList;
    }

    @PostMapping("/get")
    public School getListPerson(@RequestBody @Valid School school) {
        return school;
    }

    @GetMapping("/pershing")
    public PershingConfig pershingConfig() {
        return pershingConfig;
    }

    @PostMapping("/invest")
    public InvestmentInfoVO getInvestement(@RequestBody @Valid InvestmentInfoVO investmentInfoVO) {

        InvestmentInfoVOValidator validator = new InvestmentInfoVOValidator();
        Errors errors = new BeanPropertyBindingResult(investmentInfoVO, "InvestmentInfoVO");
        StringBuilder message = new StringBuilder();
        try {
            validator.validate(investmentInfoVO, errors);
            if (errors.hasErrors()) {
                for (ObjectError e : errors.getAllErrors()) {
                    message.append(e.getCode()).append((" "));
                }

                throw new Exception(message.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return investmentInfoVO;
    }

    @PostMapping("/custom")
    public InvestmentInfoVO getInvestement1(@RequestBody @Valid InvestmentInfoVO investmentInfoVO) {
        return investmentInfoVO;
    }

    @PostMapping("/elx")
    public Electronics getInvestement41(@RequestBody @Valid Electronics electronics) {
        return electronics;
    }

}
