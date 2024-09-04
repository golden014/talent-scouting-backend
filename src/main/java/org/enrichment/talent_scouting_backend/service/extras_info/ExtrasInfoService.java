package org.enrichment.talent_scouting_backend.service.extras_info;

import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;

import java.util.List;

public interface ExtrasInfoService {

    ExtrasInfo addExtrasInfo(ExtrasInfo extrasInfo);

    ExtrasInfo updateExtrasInfo(ExtrasInfo extrasInfo);

    void deleteExtrasInfo(ExtrasInfo extrasInfo);

    List<ExtrasInfo> getExtrasInfosByJobVacancy(Long jobVacancyId);

    List<ExtrasInfo> addExtrasInfos(List<ExtrasInfo> extrasInfos);
}
