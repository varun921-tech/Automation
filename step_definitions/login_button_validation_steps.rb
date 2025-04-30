Given('I am on the login page') do
  visit '/login'
end

Given('the username field is {string}') do |username|
  fill_in 'username', with: username unless username.empty?
end

Given('the password field is {string}') do |password|
  fill_in 'password', with: password unless password.empty?
end

When('I enter {string} into the username field') do |username|
  fill_in 'username', with: username
end

When('I enter {string} into the password field') do |password|
  fill_in 'password', with: password
end

When('I check the state of the login button') do
  # No action needed, just check the state in the Then step
end

Then('the login button should remain disabled') do
  expect(page).to have_button('Login', disabled: true)
end

Then('the login button should be enabled') do
  expect(page).to have_button('Login', disabled: false)
end