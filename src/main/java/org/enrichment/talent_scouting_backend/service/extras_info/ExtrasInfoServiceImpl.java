package org.enrichment.talent_scouting_backend.service.extras_info;

import org.enrichment.talent_scouting_backend.api.dao.extras_info.ExtrasInfoDAO;
import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExtrasInfoServiceImpl implements ExtrasInfoService {

    @Autowired
    ExtrasInfoDAO extrasInfoDAO;

    @Transactional
    @Override
    public ExtrasInfo addExtrasInfo(ExtrasInfo extrasInfo) {
        return extrasInfoDAO.addExtrasInfo(extrasInfo);
    }

    @Transactional
    @Override
    public ExtrasInfo updateExtrasInfo(ExtrasInfo extrasInfo) {
        return extrasInfoDAO.updateExtrasInfo(extrasInfo);
    }

    @Transactional
    @Override
    public void deleteExtrasInfo(ExtrasInfo extrasInfo) {
        extrasInfoDAO.deleteExtrasInfo(extrasInfo);
    }

    @Transactional
    @Override
    public List<ExtrasInfo> getExtrasInfosByJobVacancy(Long jobVacancyId) {
        return extrasInfoDAO.getExtrasInfosByJobVacancy(jobVacancyId);
    }

    @Transactional
    @Override
    public List<ExtrasInfo> addExtrasInfos(List<ExtrasInfo> extrasInfos) {
        for (ExtrasInfo extrasInfo : extrasInfos) {
            extrasInfoDAO.addExtrasInfo(extrasInfo);
        }
        return extrasInfos;
    }
}
