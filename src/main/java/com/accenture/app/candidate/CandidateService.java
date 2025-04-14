package com.accenture.app.candidate;

import java.util.List;

public interface CandidateService {
    Candidate addCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(Long id);
    void deleteCandidate(Long id);
}
