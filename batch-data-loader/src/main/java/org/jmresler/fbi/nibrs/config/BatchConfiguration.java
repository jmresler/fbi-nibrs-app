package org.jmresler.fbi.nibrs.config;

import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.lstnrs.ApplicationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {

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
                .chunk(100, transactionManager)
                .reader(new JdbcPagingItemReader<>(){{
                    setName("paging-item-reader");
                    setRowMapper(new BeanPropertyRowMapper<>(){{

                    }});
                }})
                .writer(new JpaItemWriter<>())
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
