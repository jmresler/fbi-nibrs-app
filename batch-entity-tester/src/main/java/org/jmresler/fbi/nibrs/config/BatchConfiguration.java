package org.jmresler.fbi.nibrs.config;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.dao.AgencyRepository;
import org.jmresler.fbi.nibrs.lstnrs.ApplicationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class BatchConfiguration {

    @Autowired
    protected AgencyRepository agencyRepository;

    @Bean
    public Job loadJob(
            final JobRepository repository,
            final ApplicationListener applicationListener,
            final Step loadStep
    ) {
        return new JobBuilder("load-job", repository)
                .listener(applicationListener)
                .start(loadStep)
                .build();
    }

    @Bean
    public Step loadStep(
            final PlatformTransactionManager transactionManager,
            final JobRepository repository,
            final ApplicationListener applicationListener
    ) {
        return new StepBuilder("load-step", repository)
                .listener(applicationListener)
                .tasklet((contribution, chunkContext) -> {
                    agencyRepository.findAll().forEach(agency -> {
                        log.debug(agency.toString());
                    });
                    return null;
                }, transactionManager)
                .build();
    }


    // listeners
    @Bean
    public ItemReader<Agencies> agenciesItemReader() {
        return () -> null;
    }

    @Bean
    public ItemWriter<Agencies> agenciesItemWriter() {
        return chunk -> {

        };
    }

    @Bean
    public ApplicationListener applicationListener() {
        return new ApplicationListener();
    }
}
