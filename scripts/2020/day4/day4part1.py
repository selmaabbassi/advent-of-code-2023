class PassportValidator:
    global passport
    global required_keys

    def __init__(self, passport):
        self.passport = passport
        self.required_keys = ['byr','iyr','eyr','hgt','hcl','ecl','pid'] 

    def isValidPassport(self):
        for key in self.required_keys:
            value = self.passport.get(key, 'Key not found')
            if(value == 'Key not found'):
                return 0
            else:
                continue
        return 1

if __name__ == "__main__":
    count = 0
    with open('day4.txt', 'r') as file:
        data = file.read()

    passports = data.split('\n\n')

    for p in passports:
        key_value_pairs = p.split()
        entry = {pair.split(':')[0]: pair.split(':')[1] for pair in key_value_pairs}
        validator = PassportValidator(entry)
        count += validator.isValidPassport()
    
    print(f"The number of valid passports is: {count}")