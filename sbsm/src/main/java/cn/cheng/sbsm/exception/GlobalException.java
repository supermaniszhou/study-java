//package cn.cheng.sbsm.exception;
//
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 周刘成   2020-1-16
// * *全局异常处理类 使用切面的方式捕捉异常，可以使用另外的方法处理 请看GlobalExceptionPlug
// */
////@RestControllerAdvice
//public class GlobalException {
//
//    /**
//     * 算术异常
//     * java.lang.ArithmeticException
//     * * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
//     * * 参数Exception e:会将产生异常对象注入到方法中
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = {ArithmeticException.class})
//    public ModelAndView arithmeticExceptionHandler(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error1");
//        modelAndView.addObject("error", e.toString());
//        return modelAndView;
//    }
//
//    /**
//     * java.lang.NullPointerException
//     * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
//     * 参数Exception e:会将产生异常对象注入到方法中
//     */
//    @ExceptionHandler(value = {NullPointerException.class})
//    public ModelAndView nullPointerExceptionHandler(Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error2");
//        return mv;
//    }
//
//    /**
//     * 这个方法可以替换上面的两个方法，上面两个方法可以省略掉了
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = {Exception.class})
//    public ModelAndView ExceptionHandler(Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error");
//        return mv;
//    }
//}
