package hello.core.singleton;

public class SingletonService {

  private static final SingletonService instance = new SingletonService();

  public static SingletonService getInstance() {
    return instance;
  }

  // private 으로 new 키워드를 막아두었다.
  private SingletonService() {

  }

  public void logic() {
    System.out.println("싱글톤 객체 로직 호출");
  }


}
