.PHONY: delete-test

delete-test:
	git reset --hard && git checkout master && git branch -D cars && git gc --prune=now --aggressive
