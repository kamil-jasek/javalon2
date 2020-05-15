package pl.sda.shop.info.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-15
 */
@RestController
@RequestMapping("/public")
class PublicRestController {

    @GetMapping
    String info() {
        return "info";
    }
}
