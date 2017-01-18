require "selenium-webdriver"
ENV["PATH"] = ENV["PATH"] + ":/Users/portia/Documents/workspace/Webdriver"
puts ENV["PATH"]


puts "hello world"

driver = Selenium::WebDriver.for :firefox, marionette: true



driver.navigate.to "http://google.com"

element = driver.find_element(:name, 'q')
element.send_keys "Selenium Tutorials"
element.submit

driver.quit();