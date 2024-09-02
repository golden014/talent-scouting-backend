package org.enrichment.talent_scouting_backend.service.job_vacancy;

import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.request.InsertJobVacancy;

public interface JobVacancyService {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);

    JobVacancy addJobVacancy(InsertJobVacancy data);
}
