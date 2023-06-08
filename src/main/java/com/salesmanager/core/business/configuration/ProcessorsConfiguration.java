package com.salesmanager.core.business.configuration;

import com.salesmanager.core.business.modules.order.total.PromoCodeCalculatorModule;
import com.salesmanager.core.modules.order.total.OrderTotalPostProcessorModule;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Pre and post processors triggered during certain actions such as order processing and shopping
 * cart processing
 *
 * <p>2 types of processors - functions processors Triggered during defined simple events - ex add
 * to cart checkout
 *
 * <p>- calculation processors Triggered during shopping cart and order total calculation
 *
 * <p>For events see configuratio/events
 *
 * <p>- Payment events (payment, refund)
 *
 * <p>- Change Order status
 *
 * @author carlsamson
 */
@Configuration
public class ProcessorsConfiguration {

  @Inject private PromoCodeCalculatorModule promoCodeCalculatorModule;

  /**
   * Calculate processors
   *
   * @return
   */
  @Bean
  public List<OrderTotalPostProcessorModule> orderTotalsPostProcessors() {

    List<OrderTotalPostProcessorModule> processors = new ArrayList<OrderTotalPostProcessorModule>();
    /// processors.add(new
    // com.salesmanager.core.business.modules.order.total.ManufacturerShippingCodeOrderTotalModuleImpl());
    processors.add(promoCodeCalculatorModule);
    return processors;
  }
}
