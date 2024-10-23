import re

class PassportValidator:
    global passport
    global validators

    def __init__(self, passport):
        self.passport = passport
        self.validators = {
            'byr': self.validate_byr,
            'iyr': self.validate_iyr,
            'eyr': self.validate_eyr,
            'hgt': self.validate_hgt,
            'hcl': self.validate_hcl,
            'ecl': self.validate_ecl,
            'pid': self.validate_pid
            } 

    def isValidPassport(self):
        for key in self.validators.keys():
            if key not in self.passport:
                return 0
            if not self.validators[key](self.passport[key]):
                return 0
        return 1
    
    def validate_byr(self, value):
        return 1920 <= int(value) <= 2002
    
    def validate_iyr(self, value):
        return 2010 <= int(value) <= 2020
    
    def validate_eyr(self, value):
        return 2020 <= int(value) <= 2030
    
    def validate_hgt(self, value):
        height = ''.join(filter(lambda i: i.isdigit(), value))
        if "cm" in value:
            return 150 <= int(height) <= 193
        if "in" in value:
            return 59 <= int(height) <= 76
    
    def validate_hcl(self, value):
        return bool(re.match(r'^#[0-9a-f]{6}$', value))
    
    def validate_ecl(self, value):
        return bool(re.match(r'^[amb,blu,brn,gry,grn,hzl,oth]{3}$', value))
    
    def validate_pid(self, value):
        return bool(re.match(r'^[0-9]{9}$', value))

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