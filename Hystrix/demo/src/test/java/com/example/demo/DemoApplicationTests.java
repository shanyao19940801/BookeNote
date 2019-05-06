package com.example.demo;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testCommandKey() {
		HystrixCommandTest command = new HystrixCommandTest("CommandKey");
		System.out.println(command.getCommandGroup().name());
		System.out.println(command.getCommandKey().name());
		System.out.println(command.getThreadPoolKey().name());
		System.out.println(command.getProperties().executionTimeoutInMilliseconds().get());
	}

	@Test
	public void testCommandExecute() throws Exception {
		HystrixCommandTest command = new HystrixCommandTest("execute test");
		Future<String> future1 = command.queue();
		String result1 = future1.get();
//		String result1 = future1.get(100, TimeUnit.DAYS);
		System.out.println("execute result:" + result1);
	}

	@Test
	public void testCommandObserveExecute() throws Exception {
		HystrixObservableCommandTest test = new HystrixObservableCommandTest("test");
		test.observe();
	}

	@Test
	public void testCircuitBreaker() throws Exception{
		for (int i = 0; i < 15; i++){
			Thread.sleep(500);
			HystrixCommandTest command = new HystrixCommandTest("CommandKey");
			System.out.println(command.execute());
			System.out.println(command.isCircuitBreakerOpen());
			System.out.println(command.getMetrics().getHealthCounts().getErrorPercentage());
			System.out.println("=============================");
		}
	}

	@Test
	public void testCommandCache() {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		HystrixCommandTest command1 = new HystrixCommandTest("CommandKey1");
		HystrixCommandTest command2 = new HystrixCommandTest("CommandKey1");
		HystrixCommandTest command3 = new HystrixCommandTest("CommandKey3");
		HystrixCommandTest command4 = new HystrixCommandTest("CommandKey4");

		System.out.println(command1.execute());
		System.out.println(command1.isResponseFromCache());
		System.out.println(command2.execute());
		System.out.println(command2.isResponseFromCache());
		System.out.println(command3.execute());
		System.out.println(command3.isResponseFromCache());
		System.out.println(command4.execute());
		System.out.println(command4.isResponseFromCache());

		context.shutdown();

	}

	@Test
	public void test() throws Exception {
		HystrixCommandTest command = new HystrixCommandTest("CommandKey");
		Observable<String> observe = command.observe();
		observe.subscribe(new Observer<String>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("onError");
			}

			@Override
			public void onNext(String s) {
				System.out.println("onNext");
			}
		});
		Thread.sleep(5000);
	}

}
