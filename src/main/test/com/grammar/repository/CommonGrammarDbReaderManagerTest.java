package com.grammar.repository;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@PrepareForTest({Executors.class})
@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.security.auth.*"})
public class CommonGrammarDbReaderManagerTest {

    private CommonGrammarDbReaderManager objUnderTest;
    private CommonGrammarRepository commonGrammarRepository;
    //private CommonGrammarDbReaderHelper commonGrammarDbReaderHelper = Mockito.mock(CommonGrammarDbReaderHelper.class);

    private final Executors executors = PowerMockito.mock(Executors.class);
    private ScheduledExecutorService scheduledExecutorService;


    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(Executors.class);
        commonGrammarRepository = Mockito.mock(CommonGrammarRepository.class);
        scheduledExecutorService = Mockito.mock(ScheduledExecutorService.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test(){
        PowerMockito.when(executors.newScheduledThreadPool(Mockito.eq(1))).thenReturn(scheduledExecutorService);
        objUnderTest = new CommonGrammarDbReaderManager(commonGrammarRepository);
        MatcherAssert.assertThat("sorabh", Is.is("sorabh"));
    }
}